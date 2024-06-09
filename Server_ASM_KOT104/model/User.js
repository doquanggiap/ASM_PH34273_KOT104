const { mongoose } = require('./db')
const userSchema = new mongoose.Schema(
    {
        email: { type: String, required: true },
        password: { type: String, required: true },
        fullname: { type: String, required: true },
    },
    {
        timestamps: true,
        collection: 'User'
    }
)

let User = mongoose.model('User', userSchema)

module.exports = { User }