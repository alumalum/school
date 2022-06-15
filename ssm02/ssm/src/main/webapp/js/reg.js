window.addEventListener('load', function() {
    var pwd = document.querySelector('#pwd');
    var regpwd = /^[a-zA-Z0-9_-]{6,10}$/;
    var sure = document.querySelector('#sure');
    regexp(pwd, regpwd);
    function regexp(ele, reg) {
        ele.addEventListener('blur', function() {
            if (reg.test(this.value)) {

            } else {

            }
        })
    }
    sure.addEventListener('blur', function() {
        if (this.value == pwd.value) {
            this.nextElementSibling.className = 'success';
            this.nextElementSibling.innerHTML = '<i class="success_icon"></i> 恭喜您输入正确';
        } else {
            this.nextElementSibling.className = 'error';
            this.nextElementSibling.innerHTML = '<i class="error_icon"></i> 两次密码输入不一致 ';
        }
    })
})