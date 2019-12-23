'use strict';
window.onload = function() {
  var myMonthArry = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

  // inputSelectYear要素の取得
  var inputSelectYear = document.querySelector("#inputSelectYear");
  var year = inputSelectYear.value
  console.log(inputSelectYear.value);
  // inputSelectMonth要素の取得
  var inputSelectMonth = document.querySelector("#inputSelectMonth");

  // option要素の取得（配列）
  // var inputSelectYearOptions = document.querySelectorAll("#inputSelectYear option");

  // option要素の取得（配列）
  var inputSelectMonthOptions = document.querySelectorAll("#inputSelectMonth option");

  // inputSelectMonth要素の取得
  var inputSelectDay = document.querySelector("#inputSelectDay");

  year = inputSelectYear.value
  if (year % 4 === 0 && (year % 100 !== 0 || year % 400 !== 0)) {
    myMonthArry[1] = 29;
  } else {
    myMonthArry[1] = 28;
  }

  inputSelectDay.textContent = null;
  for (var i = 1;i <= myMonthArry[inputSelectMonth.value - 1];i++) {
    // FIXME
    let option = document.createElement('option');
    option.value = i;
    option.text = i;
    inputSelectDay.appendChild(option);
  }

  // inputSelectYear要素のchangeイベントの登録
  inputSelectYear.addEventListener('change', function() {
      // http://shanabrian.com/web/javascript/removechild.php
      //if (inputSelectDay.options.length !== 1) {
      year = inputSelectYear.value
      if (year % 4 === 0 && (year % 100 !== 0 || year % 400 !== 0)) {
        myMonthArry[1] = 29;
      } else {
        myMonthArry[1] = 28;
      }

      inputSelectDay.textContent = null;
      for (var i = 1;i <= myMonthArry[inputSelectMonth.value - 1];i++) {
        // FIXME
        let option = document.createElement('option');
        option.value = i;
        option.text = i;
        inputSelectDay.appendChild(option);
      }
    //}



  });

  // inputSelectMonth要素のchangeイベントの登録
  inputSelectMonth.addEventListener('change', function(){
      // http://shanabrian.com/web/javascript/removechild.php
      //if (inputSelectDay.options.length !== 1) {
      year = inputSelectYear.value
      inputSelectDay.textContent = null;
      for (var i = 1;i <= myMonthArry[inputSelectMonth.value - 1];i++) {
        // FIXME
        let option = document.createElement('option');
        option.value = i;
        option.text = i;
        inputSelectDay.appendChild(option);
      }

    //}


  });




  var submit = document.getElementById('submit');
  inputSelectDay = document.getElementById('inputSelectDay');
  var y = inputSelectYear.value;
  var m = inputSelectMonth.value;
  var d = inputSelectDay.value;
  inputSelectDay.value = (y + m + d);
  console.log(inputSelectYear.value);
  console.log(inputSelectMonth.value);
  console.log(inputSelectDay.value);
  console.log(inputSelectDay.value);
  if (submit == null) {
    submit = document.getElementById('submit');
  }
  console.log(submit);
  submit.addEventListener('click', () => {
    var inputEmailAddress = document.getElementById('inputEmailAddress').value;
    var inputEmailAddressConfirm = document.getElementById('inputEmailAddressConfirm').value;
    var inputPassword = document.getElementById('inputPassword').value;
    var inputPasswordConfirm = document.getElementById('inputPasswordConfirm').value;

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
  })}


