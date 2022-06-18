console.log("External Js Testing Alert Here...");
const toggleSidebar=()=>{
	// alert("We are Inside");
	if($('.sidebar').is(":visible")){
		// true rahega to
		// band krna hai
		$(".sidebar").css("display", "none");
		$(".content").css("margin-left", "0%");
	}else{
		// false rahega to
		// show karana hai
		$(".sidebar").css("display", "block");
		$(".content").css("margin-left", "20%");
	}
};