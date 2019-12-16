'use strict';
window.onload = function() {
  var submit = document.getElementById('submit');

  console.log(submit);
  if (submit == null) {
    submit = document.getElementById('submit');
  }
  console.log(submit);
  submit.addEventListener('click', () => {
    var inputEmailAddress = document.getElementById('inputEmailAddress').value;
    var inputEmailAddressConfirm = document.getElementById('inputEmailAddressConfirm').value;
    var inputPassword = document.getElementById('inputPassword').value;
    var inputPasswordConfirm = document.getElementById('inputPasswordConfirm').value;
    console.log('デバッグ中2');

    if (inputEmailAddress != inputEmailAddressConfirm) {
        event.preventDefault();
        alert('メールアドレスが一致しません。');
      } else if (inputPassword != inputPasswordConfirm) {
        event.preventDefault();
        alert('パスワードが一致しません。');
      }
      var request = new XMLHttpRequest();
      request.open('GET', 'http://localhost:8080/project1/registered_check\?emailAddress=' + inputEmailAddress, false);
      request.send('\?emailAddress=' + inputEmailAddress);
      if (request.responseText === 'true') {
        event.preventDefault();
        alert('メールアドレスが登録されているため登録できません。');
      }
      console.log(request.responseText);
        // // TODO サーバーからのレスポンスでメールアドレスが登録済みだったらポップアップを表示して、画面遷移を中止
  })}


