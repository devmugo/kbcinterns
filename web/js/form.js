
function validate() {


    if (document.myForm.id.value == "" || isNaN(document.myForm.id.value) ||
            document.myForm.id.value.length != 8) {
        document.getElementById('iderror').innerHTML = '';
         document.getElementById('iderror').innerHTML = 'Invalid id';
        text = "Please Input Correct Id"
        document.myForm.id.focus();

        return false;
    }

    if (document.myForm.pass.value != document.myForm.pass2.value) {
        document.getElementById('passerror').innerHTML = '';
        document.myForm.pass.focus();
         document.getElementById('passerror').innerHTML = 'Password do not match';
        return false;
    }
    if (document.myForm.phone.value == "" ||
            document.myForm.phone.value.length != 10) {
          document.getElementById('phoneerror').innerHTML = '';
           document.getElementById('phoneerror').innerHTML = 'Invalid phone number';
         document.myForm.phone.focus();

        return false;
    }
    return(true);
}







