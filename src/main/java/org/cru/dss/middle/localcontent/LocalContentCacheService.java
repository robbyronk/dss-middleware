package org.cru.dss.middle.localcontent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

public class LocalContentCacheService
{
//	private static final ReadWriteLock indexLock = new ReentrantReadWriteLock();
	
    private IndexSearcher indexSearcher;
    private IndexReader indexReader;

    private String rootContentDir;
    private Directory indexDir;
    private String contentDir;

    public LocalContentCacheService(String rootContentDir)
    {
        init(rootContentDir);
    }
    
    public void saveContentItemToCache(ContentItem content) throws CorruptIndexException, IOException
    {
    	Document luceneDoc = new Document();
    	luceneDoc.add(new Field("ucmId", content.getUcmId(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    	luceneDoc.add(new Field("designation", content.getDesignation(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    	luceneDoc.add(new Field("pageContent", new String(content.getContentBytes(),"UTF-8"), Field.Store.YES, Field.Index.ANALYZED));
    	luceneDoc.add(new Field("filename", content.getFilename(), Field.Store.YES, Field.Index.NOT_ANALYZED));
    	if(content.getTitle() != null) luceneDoc.add(new Field("title", content.getTitle(), Field.Store.YES, Field.Index.NOT_ANALYZED));

    	//    	indexLock.writeLock().lock();
    	IndexWriter writer = openWriter();
    	writer.addDocument(luceneDoc);
    	writer.commit();
    	writer.close();
    	//  	indexLock.writeLock().unlock();
    	
    }
    
    private void init(String rootContentDir)
    {
    	if(this.rootContentDir == null)
    	{

    		System.out.println("Initializing LocalContentCacheService... rootContentDir=" + rootContentDir);

    		try
    		{
    			indexDir = new SimpleFSDirectory(new File(rootContentDir + "/index"));
    		}
    		catch(IOException ioe)
    		{
    			throw new RuntimeException("Unable to create directory", ioe);
    		}
    		
    		contentDir = rootContentDir + "/data";

    		File dir = new File(contentDir);
    		if(!dir.exists()) dir.mkdirs();

    		// signify that we are done
    		this.rootContentDir = rootContentDir;

    		openReader();
    	}
    }
    
    private void setIndexReader(IndexReader reader)
    {
        this.indexReader = reader;
    }
    
    private void setIndexSearcher(IndexSearcher searcher)
    {
    	indexSearcher = searcher;
    }
    
    private IndexReader getIndexReader()
    {
        return indexReader;
    }
    
    private IndexSearcher getIndexSearcher()
    {
    	return indexSearcher;
    }
    
    private List<Document> searchIndexWithQuery(Query query) throws IOException,CorruptIndexException
	{
        TopScoreDocCollector collector  = TopScoreDocCollector.create(500, true);
		List<Document> list;
//		indexLock.readLock().lock();
        {
        	IndexSearcher searcher = getIndexSearcher();
        	if(searcher == null) throw new NullPointerException("searcher was null, but why?");
        	searcher.search(query, collector);

        	ScoreDoc[] docs = collector.topDocs().scoreDocs;
        	list = new ArrayList<Document>(docs.length);

        	for(ScoreDoc hit : docs)
        	{
        		list.add(getIndexSearcher().doc(hit.doc));
        	}
        }
//        indexLock.readLock().unlock();
        
        return list;
	}
    
    private void openReader()
    {
    	try
    	{
    		try
    		{
    			setIndexReader(IndexReader.open(indexDir));
    		}
    		catch(FileNotFoundException e)
    		{
    			IndexWriter indexWriter = openWriter();
    			indexWriter.close();
    			setIndexReader(IndexReader.open(indexDir));
    		}
    		setIndexSearcher(new IndexSearcher(getIndexReader()));
        
    	}
    	catch(IOException ioe)
    	{
    		throw new RuntimeException(ioe);
    	}
    }
    
    private void reopenReader() throws IOException
    {
    	init(rootContentDir);
    	
        if(getIndexReader() != null && !getIndexReader().isCurrent())
        {
        	//make sure no one writes to the index while we're restarting it.
//        	indexLock.writeLock().lock();
        	getIndexReader().close();
        	openReader();
//        	indexLock.writeLock().unlock();
        }
    }
    
    private IndexWriter openWriter() throws CorruptIndexException, IOException
    {
        try
        {
            return new IndexWriter(indexDir, new StandardAnalyzer(Version.LUCENE_30), false, IndexWriter.MaxFieldLength.LIMITED);
        }
        catch(FileNotFoundException e)
        {
            return new IndexWriter(indexDir, new StandardAnalyzer(Version.LUCENE_30), true, IndexWriter.MaxFieldLength.LIMITED);
        }
    }    
}
