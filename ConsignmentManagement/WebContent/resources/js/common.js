$( document ).ready(function() {
	window.onload = disableBack();
	window.onpageshow = function(evt) { if (evt.persisted) disableBack() ;};

	applyAugCal();
	
$('.addmore').each(function (i,sk){
	
	new addmorefun($(sk));
});
bindfileupload(document);
addtooltips();

fontsizehandler();

});


function disableBack() { window.history.forward(); }

function bindfileupload(dt){
	$(dt).find("input[type='file']").each(function (){
		
		$(this).change(function(){
		var fname=	$(this).val();
		if($(this).hasClass('excelfile')){
			if(fname.indexOf('.xls')<2 && fname.indexOf('.XLS')<2 && fname.indexOf('.xlsx')<2 &&
					fname.indexOf('.XLSX')<2 ){
				
				alert("Invalid file type! Please select excel file.");
				$(this).val('');
				
				return;
			}	
			
		}else{//
		if(fname.indexOf('.jpg')<2 && fname.indexOf('.JPG')<2 && fname.indexOf('.jpeg')<2 &&
				fname.indexOf('.JPEG')<2 && fname.indexOf('.png')<2 && fname.indexOf('.PNG')<2 &&
				fname.indexOf('.pdf')<2 && fname.indexOf('.PDF')<2 ){
			
			alert("Invalid file type! Please select image file or pdf file.");
			$(this).val('');
			
			return;
		}}
		var st=fname.split('.');
	//	alert(st.length)
		if(st.length>2){
			alert("Double ext file not allowed.");
			$(this).val('');
		}
		
	var maxsize=(1024*1024);
	var fl=	 this.files[0];
	if($(this).hasClass('bigsizefile')){
		maxsize=(1024*1024*5);
		if(fl.size > maxsize){
			alert("Allowed file size exceeded. (Max. 5 MB)");
			$(this).val('');
			return;
		}
	}else{
		
	}
	var maxsize=(1024*1024*2);
	var fl=	 this.files[0];
	if($(this).hasClass('twombsizefile')){
		maxsize=(1024*1024*2);
		if(fl.size > maxsize){
			alert("Allowed file size exceeded. (Max. 2 MB)");
			$(this).val('');
			return;
		}
	}else{
		
	}
	var maxsize=(1024*1024);
	var fl=	 this.files[0];
	if($(this).hasClass('onembsizefile')){
		if(fl.size>maxsize){
			alert("Allowed file size exceeded. (Max. 1 MB)");
			$(this).val('');
			return;
		}
	}
	
	var maxsize=(1024*1024*20);
	var fl=	 this.files[0];
	if($(this).hasClass('twentymbsizefile')){
		maxsize=(1024*1024*20);
		if(fl.size > maxsize){
			alert("Allowed file size exceeded. (Max. 20 MB)");
			$(this).val('');
			return;
		}
	}else{
		
	}
	
	var maxsize=(1024*1024*100);
	var fl=	 this.files[0];
	if($(this).hasClass('hundmbsizefile')){
		maxsize=(1024*1024*100);
		if(fl.size > maxsize){
			alert("Allowed file size exceeded. (Max. 100 MB)");
			$(this).val('');
			return;
		}
	}else{
		
	}
	
	var maxsize=(1024*1024*10);
	var fl=	 this.files[0];
	if($(this).hasClass('tenmbsizefile')){
		maxsize=(1024*1024*10);
		if(fl.size > maxsize){
			alert("Allowed file size exceeded. (Max. 10 MB)");
			$(this).val('');
			return;
		}
	}else{
		
	}
	
	
	
	});
});
}
	



function addtooltips(){
	
	 $('input[rel="txtTooltip"]').tooltip();
	 $('select[rel="txtTooltip"]').tooltip();
	 $('textarea[rel="txtTooltip"]').tooltip();
}





STSTK_PARNTDV= new Array();
STSTK_DVCNT= new Array();

var addmorefun=  function( tk){
	var did=$(tk).attr('id')+"-dv";
this.divcnt =$('#'+did);

this.parntdv=$('#'+did).parent();
STSTK_PARNTDV[$(tk).attr('id')]=this.parntdv;
STSTK_DVCNT[$(tk).attr('id')]=this.divcnt.html();


this.clkfun=function(){
var st=$("<div class='addmoredv'></div>");

$(st).html(STSTK_DVCNT[this.id]);

$(STSTK_PARNTDV[this.id]).append(st);
$(st).find("input").each(function (){
	var typ=$(this).attr("type");
	if(typ=='radio' || typ=='checkbox'){
		$(this).prop('checked', false);
		var nam=$(this).attr("name");
		$(this).attr('name',nam+num);
	}
	else{
	$(this).val("");}
	});

$(st).find(".filespan").each(function (){	$(this).html("");});

$(st).find("select").each(function (){	$(this).val("0");});
$(st).find("textarea").each(function (){	$(this).val("");});


$(st).find('.dynaselectfld').each(function(){
	var did=$(this).attr('id');
	$(this).attr('id',did+num);

});
num=num+1;

$(st).find('.dynaeditablefilefld').each(function(){
		
var spn=$(this).find(".spnbtnclass");
var sid=$(spn).attr('id');
	$(this).find(".Container"+sid).show();


	$(this).find(".filename"+sid).remove();

	$(spn).remove();
	});



applyAugCal();
addtooltips();
bindfileupload(st);
};



$(tk).click(this.clkfun);

	
};


var num=100;
function deloptdvss(stk) {
	var cts = $(stk).parent();

	var x = 0;
	while (!$(cts).hasClass('addmoredv')) {

		var cts1 = $(cts).parent();
		cts = cts1;
		x = x + 1;
	}

	var xxx = 0;
	$(document).find(".addmoredv").each(function() {
		xxx++;
	});

	if (xxx > 1) {
		$(cts).remove();
	}
}

function deloptdv(stk){

	var cts=$(stk).parent();

	var x=0;
	while(! $(cts).hasClass('addmoredv') && x<5){
	
	var	cts1=$(cts).parent();
	cts=cts1;
		x=x+1;
	}

	if($(cts).hasClass('addmoredv')){
		
		if($(stk).hasClass('requiredonedv')){
		var	pant=$(cts).parent();
		var _indx=0;
		$(pant).find('.addmoredv').each(function(){
			_indx=_indx+1;
		});
		if(_indx<2){
			alert("You can't delete. Atleast one record is required");
			return false;
		}
		}
		$(cts).html('');
		$(cts).remove();
	}
}


function architecBlock(stk){

	var cts=$(stk).parent();

	var x=0;
	while(! $(cts).hasClass('addmoredv') && x<5){
	
	var	cts1=$(cts).parent();
	cts=cts1;
		x=x+1;
	}

	var a=document.forms["trxForm"]["architectName"].value;
    /*var b=document.forms["Form"]["answer_b"].value;
    var c=document.forms["Form"]["answer_c"].value;
    var d=document.forms["Form"]["answer_d"].value;*/
	if(a==null || a==""){
		alert("Please Fill All Required Field"+a);
		$(cts).remove();
	}
}



function editfilefieldenable(spn){
	
var dv=	$(spn).parent();
var sid=$(spn).attr("id");
var x=0;
//while(! $(dv).hasClass(".Containerdv"+sid) && x<5){

//dv=$(dv).parent();	
//x=x+1;
//}
$(dv).find(".Container"+sid).show();


$(dv).find(".filename"+sid).remove();

$(spn).remove();



}





	   
	   function fontsizehandler(){
		   
		   $(".acceblity").click(toggleBG);
		   
		   
		   $("h1").css("font-size","16px");
			$("h2").css("font-size","14px");
			$("h3").css("font-size","15px");
			$("h4").css("font-size","13px");
			$("h5").css("font-size","12px");
			$("h6").css("font-size","11px");
			$("body,a,input,label,textarea,select,td,th,p,span,div,ul,li").css("font-size","13px");
	   $("h1 span").css("font-size","16px");
			   
				
				 $("ul.font-zoom li.clsButton").bind("click", function () {

						var size = parseInt($("body").css("font-size"));
						var h1size = parseInt($("h1").css("font-size"));
						var h2size = parseInt($("h2").css("font-size"));
						var h3size = parseInt($("h3").css("font-size"));
						var h4size = parseInt($("h4").css("font-size"));
						var h5size = parseInt($("h5").css("font-size"));
						var h6size = parseInt($("h6").css("font-size"));
				 //Manipulating font size of following HTML tag body,a,input,textarea,select,td,th,p,span,div
				
						
						
						 if ($(this).hasClass("a-plus")) {
				                size = size + 1;
								 if (size >=20) {
				                    size = 20;
				                }
				                $("body,a,input,textarea,select,td,th,p,span,div,label,ul,li").css("font-size", size);
				            } else if ($(this).hasClass("a-minus")) {
				                size = size - 1;
				                if (size <= 10) {
				                    size = 10;
				                }
				                $("body,a,input,textarea,select,td,th,p,label,span,div,ul,li").css("font-size", size);
				            } else if ($(this).hasClass("clsBold")) {
				               // $("body").css("font-weight", "Bold");
				            } else if ($(this).hasClass("clsItalic")) {
				               // $("body").css("font-style", "italic");
				            }
				            else if ($(this).hasClass("a-normal")) {
				                $("body,a,input,textarea,select,td,th,p,span,div,label,ul,li").css("font-size", "13px");
								 $("h1 span").css("font-size", "16px");
				                //$("body,a,input,textarea,select,td,th,p,span,div").css("font-style", "normal");
				                //$("body,a,input,textarea,select,td,th,p,span,div").css("font-weight", "normal");
				            }
							
						
							//Manipulating font size of H1 tag
							if($(this).hasClass("a-plus")){
								 h1size = h1size+1;
								if(h1size>=20){
								h1size = 20;
								}
							$("h1").css("font-size",h1size);
							}
							
							else if($(this).hasClass("a-minus")){
								 h1size = h1size-1;
								if(h1size<=10){
								 h1size = 10;
								}
								$("h1").css("font-size",h1size);
							}
							
							else if($(this).hasClass("a-normal")){
								$("h1").css("font-size","16px")
							}
						 	
							
							//Manipulating font size of H2 tag
							  if($(this).hasClass("a-plus")){
							  h2size = h2size + 1;
							  if (h2size >=20){
								  	h2size = 20;
								  }
							  $("h2").css("font-size",h2size);
							  }
						  else if ($(this).hasClass("a-minus")){
						  		 h2size = h2size - 1;
							  if (h2size <=12){
								  	h2size = 12;
								  }
						  	$("h2").css("font-size",h2size);
						  }
						  
						  else if($(this).hasClass("a-normal")){
								
						  	$("h2").css("font-size","14px");
								}
							
							
							//Manipulating font size of H3 tag
							if($(this).hasClass("a-plus")){
								h3size	= 	h3size+1;
								if(h3size>=20){
									h3size	= 	20;
								}
								$("h3").css("font-size",h3size);
							}
							
							else if($(this).hasClass("a-minus")){
								h3size = h3size-1;
								if(h3size<=10){
									h3size = 10;	
								}
								$("h3").css("font-size",h3size);
							}
							
							else if($(this).hasClass("a-normal")){
								$("h3").css("font-size","15px");
							}
							
							//Manipulating font size of H4 tag
							if($(this).hasClass("a-plus")){
								h4size	= 	h4size+1;
								if(h4size>=16){
									h4size	= 	16;
								}
								$("h4").css("font-size",h4size);
							}
							
							else if($(this).hasClass("a-minus")){
								h4size = h4size-1;
								if(h4size<=10){
									h4size = 10;	
								}
								$("h4").css("font-size",h4size);
							}
							
							else if($(this).hasClass("a-normal")){
								$("h4").css("font-size","13px");
							}
							
							//Manipulating font size of H5 tag
							if($(this).hasClass("a-plus")){
								h5size	= 	h5size+1;
								if(h5size>=15){
									h5size	= 	15;
								}
								$("h5").css("font-size",h5size);
							}
							
							else if($(this).hasClass("a-minus")){
								h5size = h5size-1;
								if(h5size<=10){
									h5size = 10;	
								}
								$("h5").css("font-size",h5size);
							}
							
							else if($(this).hasClass("a-normal")){
								$("h5").css("font-size","12px");
							}
							
							//Manipulating font size of H6 tag
							if($(this).hasClass("a-plus")){
								h6size	= 	h6size+1;
								if(h6size>=14){
									h5size	= 	14;
								}
								$("h6").css("font-size",h6size);
							}
							
							else if($(this).hasClass("a-minus")){
								h6size = h6size-1	;
								if(h6size<=9){
									h5size = 9;	
								}
								$("h6").css("font-size",h6size);
							}
							
							else if($(this).hasClass("a-normal")){
								$("h6").css("font-size","11px");
							}

				
	        });
		}
	   
	   
	//End font size descrease.


   function toggleBG(){
	   
	   
	  
	        $(".top-logo").toggleClass("accesbilitie_theme");
			$(".content").toggleClass("accesbilitie_theme");
			$("body").toggleClass("accesbilitie_theme");
			$("footer").toggleClass("footer_disble");
			$(".top-logo").toggleClass("top-logo_disble");
			$(".navbar-default").toggleClass("nav_dasability");
			$("footer ul li a").toggleClass("footer_disble_m");
			$(".ch-person").toggleClass("nav_dasability");
			$(".ch-person h4").toggleClass("nav_dasability");
			$(".ch-person a").toggleClass("nav_dasability");
			$(".logo-sec").toggleClass("logo-sec_accesibility");
			$(".ut_name").toggleClass("ut_name_accesibility");
			$(".flipkart-navbar-button").toggleClass("nav_btn_dasability");
			$(".news_cover").toggleClass("news_cover_accebility");
			$(".navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:focus, .navbar-default .navbar-nav > .active > a:hover").toggleClass("nav_active");
			
	
   }










