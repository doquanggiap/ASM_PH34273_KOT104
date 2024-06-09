const { User } = require("../model/User")

exports.layDanhSach = async (req, res) => {
    try {
        const data = await User.find()

        if (data) {
            res.json({
                status: 200,
                message: "Lấy danh sách thành công",
                data: data
            })
        } else {
            res.json({
                status: 400,
                message: "Lấy danh sách thất bại",
                data: []
            })
        }
    } catch (error) {
        res.status(400).json({
            "msg": error.message
        })
    }
}

exports.DangKy = async (req, res) => {
    try {
        const data = req.body

        // Kiểm tra xem email đã tồn tại hay chưa
        const existingUser = await User.findOne({ email: data.email })
        if (existingUser) {
            return res.json({
                status: 400,
                message: "Email đã tồn tại",
                data: []
            })
        }

        const objUser = new User({
            email: data.email,
            password: data.password,
            fullname: data.fullname
        })

        const result = await objUser.save()
        if (result) {
            res.json({
                status: 200,
                message: "Đăng ký thành công",
                data: result
            })
        } else {
            res.json({
                status: 400,
                message: "Đăng ký thất bại",
                data: []
            })
        }
    } catch (error) {
        res.status(400).json({
            "msg": error.message
        })
    }
}

exports.DangNhap = async (req, res) => {
    try {
        const { email, password } = req.body

        // Kiểm tra xem email có tồn tại trong cơ sở dữ liệu hay không
        const user = await User.findOne({ email })
        if (!user) {
            return res.json({
                status: 400,
                message: "Email không tồn tại",
                data: []
            })
        }

        // Kiểm tra xem mật khẩu có đúng hay không
        if (user.password !== password) {
            return res.json({
                status: 400,
                message: "Mật khẩu không đúng",
                data: []
            })
        }

        // Nếu email và mật khẩu đều đúng, trả về thông tin người dùng
        res.json({
            status: 200,
            message: "Đăng nhập thành công",
            data: user
        })
    } catch (error) {
        res.status(400).json({
            "msg": error.message
        })
    }
}