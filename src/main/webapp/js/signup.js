 const phoneNumber = (target) => {
        
    	const phoneNumberValue = target.value.replace(/-/g, '').replace(/[^0-9]/g, '');
    	let formattedNumber = "";

    	if (phoneNumberValue.length >= 4 && phoneNumberValue.length <= 7) {
        	formattedNumber = phoneNumberValue.replace(/(\d{3})(\d{1,4})/g, "$1-$2");
    	} else if (phoneNumberValue.length > 7) {
        	formattedNumber = phoneNumberValue.replace(/(\d{3})(\d{4})(\d{0,4})/g, "$1-$2-$3");
    	} else {
        	formattedNumber = phoneNumberValue;
    	}

    	target.value = formattedNumber;



   
    	sendDataToServer(phoneNumberValue);
	}