var submit = document.getElementById('submit');

submit.addEventListener('click', () => {
  var inputEmailAddress = document.getElementById('inputEmailAddress').value;
  var inputEmailAddressConfirm = document.getElementById('inputEmailAddressConfirm').value;
  var inputPassword = document.getElementById('inputPassword').value;
  var inputPasswordConfirm = document.getElementById('inputPasswordConfirm').value;

  if (inputEmailAddress != inputEmailAddressConfirm) {
      event.preventDefault();
      alert("メールアドレスが一致しません。");
    } else if (inputPassword != inputPasswordConfirm) {
      event.preventDefault();
      alert("パスワードが一致しません。")
    } else {
      var request = new XMLHttpRequest();
      request.open('GET', './registered_check'. false);
      request.send(inputEmailAddress)
      console.log(request.responseText);
    }
})


