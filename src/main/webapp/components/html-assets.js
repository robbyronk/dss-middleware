'use strict';


try {
	Typekit.load({
		active: function() { 
			jQuery('body').trigger('fonts_active');
		}
	});
} catch(e){}


function emailThis() {
	window.location = "mailto:?subject="+escape("Online Giving - Cru " + document.title) +
		"&body=" + document.title + "%0A" + escape(location.href);
}

function cPop(url, wide, high) {
	window.open(url,"popup",'width=' + wide + ',height=' + high); 
} 

//Global variable for search options (i.e. current site, directory, or all sites)
var selection;

function chooseSearch(var1, var2, var3) {
	var currentSelection = document.getElementById(var1);
	var li2 = document.getElementById(var2);
	var li3 = document.getElementById(var3);
	
	//Apply styling to the selected option and remove styling from other options
	currentSelection.className = "selected";
	li2.className = "";
	li3.className = "";
	
	selection = currentSelection.id;
	
	return false;
}

function setPubWebSearch(engine)
{
	//If no option has been chosen, set the default search
	if(selection == undefined)
		selection = 'give';
	
	if (selection=="give")
	{
		document.search.action = "https://give.cru.org/give?Action=ProcessPage&Page=VirtualCommonLinks&Listener=search2";
		document.search.method = "post";
		document.search.Query.disabled=false;
		document.search.Query.value = document.search.ssUserText.value;
	}
	else {
		if (selection=="cru"){
    		document.search.action = 'http://www.cru.org/search/index.htm?ssUserText=';
    		//document.search.action = 'search/index.htm?';
    		document.search.method = "get";
    		document.search.Query.disabled=true;                        
		} 
		else {
    		document.search.action = 'http://www.cru.org/search/all/index.htm?ssUserText=';
    		//document.search.action = 'search/all/index.htm?';
    		document.search.method = "get";
    		document.search.Query.disabled=true;
		}
	}
}

function toggle_div(options, triangles) {
	var flip = document.getElementById(options);
	var shape = document.getElementById(triangles);
	if(flip.style.display == "block"){
		flip.style.display = "none";
		shape.style.borderTop = "5px solid \#F9B625";
		shape.style.borderBottom = "none";
		shape.style.marginLeft = "3px";
	}
	else{
		flip.style.display = "block";
		shape.style.borderBottom = "5px solid \#F9B625";
		shape.style.borderTop = "none";
		shape.style.marginLeft = "4px";
					
	}
	return false;
}