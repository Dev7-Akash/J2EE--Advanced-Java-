
function validate(frm){
	//empty the existing error messages
	document.getElementById("pnameErr").innerHTML="";
	document.getElementById("pageErr").innerHTML="";
	document.getElementById("paddrsErr").innerHTML="";
	
	//read form data
	let name=frm.pname.value;
	let age=frm.page.value;
	let addrs=frm.paddrs.value;
	
	//client side validation
	let vflag=true;
	
	if(name==""){
		document.getElementById("pnameErr").innerHTML="<b>Person Name Is Required</b>";
		vflag=false;
	}
	else if(name.length<5){
		document.getElementById("pnameErr").innerHTML="<b>Person Name Must contain Min 5 Characters</b>";
		vflag=false;
	}
	
	if(age==""){
		document.getElementById("pageErr").innerHTML="<b>Person Age Is Required</b>";
		vflag=false;
	}
	else if(isNaN(age)){
		document.getElementById("pageErr").innerHTML="<b>Person Must Be A Numeric Value</b>";
		vflag=false;
	}
	else if(age<=0||age>=126){
		document.getElementById("pageErr").innerHTML="<b>Person Age Must Be In The Range Of 1 To 125</b>";
		vflag=false;
	}
	
	if(addrs==""){
		document.getElementById("paddrsErr").innerHTML="<b>Person Address Is Required</b>";
		vflag=false;
	}
	
	return vflag;
}