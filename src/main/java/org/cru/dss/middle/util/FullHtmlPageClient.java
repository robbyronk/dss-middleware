package org.cru.dss.middle.util;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

public class FullHtmlPageClient
{
	static Pattern specificCssPattern = Pattern.compile("/ucmcons/fragments/cru_give_assets");
	static Pattern imagePattern = Pattern.compile("/ucmcon[s-t]/groups/public/.*stillimage/");
	
	public String fetchPage(String designation) throws IOException
	{
		String html = getResponseAsStringFromUrl(new URL("https://give.cru.org/" + designation));
		
		html = html.replaceAll(specificCssPattern.pattern(), "https://give.cru.org");
		html = html.replaceAll(imagePattern.pattern(), "/dss-middleware/rest/getImage/");
		
		return html;
	}

	private String getResponseAsStringFromUrl(URL url) throws IOException
	{
		java.util.Scanner scanner = new java.util.Scanner(url.openConnection().getInputStream()).useDelimiter("\\A");
		return scanner.hasNext() ? scanner.next() : "";
	}
}
