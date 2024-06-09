const mongoose = require('mongoose');
mongoose.connect('mongodb+srv://giapdqph34273:G4QDVOvdVebuHJEP@testmongodb.3f1oxwh.mongodb.net/ASM_KOT104')
    .then(() => console.log('Kết nối thành công'))
    .catch((err) => {
        console.log("Loi ket noi CSDL");
        console.log(err);
    });

module.exports = { mongoose }