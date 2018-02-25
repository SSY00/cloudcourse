/**
 * 
 */
function add(){
	
    var input1 = document.createElement('input');
    input1.setAttribute('type', 'text');
    input1.setAttribute('name', 'interest');
    input1.setAttribute('id', 'interest');
    
    var btn1 = document.getElementById("org");
    btn1.insertBefore(input1,null);
}
function del(){
	  var el = document.getElementById('interest');
	     el.parentNode.removeChild(el);
}