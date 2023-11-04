function count(type)  {
	
  const totalQty = document.getElementById('result');

  let number = resultElement.innerText;

  if(type === 'plus') {
    number = parseInt(number) + 1;
  }
  else if(type === 'minus')  {
    number = parseInt(number) - 1;
  }
  resultElement.innerText = number;
  }
  