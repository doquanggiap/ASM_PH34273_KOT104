var express = require('express');
var router = express.Router();
var UserCtrl = require('../controller/UserController');

router.get('/users', UserCtrl.layDanhSach)

router.post('/register', UserCtrl.DangKy)

router.post('/login', UserCtrl.DangNhap)


module.exports = router;
