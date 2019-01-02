var json_clbk_fun =new Array();
json_clbk_fun['default']=function(_ob){
	alert(_ob.divid);
};

JSONServ=function(_dv,_url,_prm,_callbck){
this.acturl=_url;
this.param=_prm+"&divid="+_dv+"&callback="+	_callbck;
this.load=function(){
		 
		  $.ajax({  
			    type: "POST",  
			    url: this.acturl,  
			    data: this.param,
			    dataType: "json",
			    async: false,
			    success:this.calbk,
			    error: function(jqXHR, textStatus, errorThrown){
		            alert('error: ' + textStatus + ': ' + errorThrown);
		            
		        }
			});

	  };
	  
	  this.calbk=function(_res){
	
		  json_clbk_fun[_res.callbck]($('#'+_res.divid),_res);  
	  };
}