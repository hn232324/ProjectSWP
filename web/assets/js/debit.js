/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */



var abtract = document.getElementById("abtract");
var plus = document.getElementById("plus");
function selectOptionAbtract() {

    document.getElementById("plus2").value = "false";
    document.getElementById("abtract2").value = "true";
    document.getElementById("abtract").classList.remove("btn-secondary");
    document.getElementById("abtract").classList.add("btn-primary");
    document.getElementById("plus").classList.add("btn-secondary");
}
function selectOptionPlus() {

    document.getElementById("plus2").value = "true";
    document.getElementById("abtract2").value = "false";
    document.getElementById("plus").classList.remove("btn-secondary");
    document.getElementById("plus").classList.add("btn-primary");
    document.getElementById("abtract").classList.add("btn-secondary");
}


function getConvert() {
    var money = document.getElementById("txttien").value;// get giá trị của người dùng vừa nhập vào
    var word = convertMoneyToWords(money);
    document.getElementById("convertWord").innerHTML = word;
}
function convertMoneyToWords(money) {
    const ones = [
        "", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"
    ];
    const tens = [
        "", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"
    ];
    const scales = [
        "", "nghìn", "triệu", "tỷ", "nghìn tỷ", "triệu tỷ"
    ];

    let words = "";

    if (money == 0) {
        words = "không đồng";
        return words;
    }

    if (money < 0) {
        words = "âm ";
        money = -money;
    }

    let numGroups = 0;

    while (money > 0) {
        let group = money % 1000;
        money = Math.floor(money / 1000);

        let onesText = ones[group % 10];
        let tensText = tens[Math.floor(group / 10) % 10];
        let hundredsText = ones[Math.floor(group / 100) % 10];

        let groupWords = "";

        if (hundredsText != "") {
            groupWords += hundredsText + " trăm ";
        }

        if (tensText == "mười" && onesText != "") {
            tensText = "mười ";
        }

        if (tensText != "") {
            groupWords += tensText;
        }

        if (tensText != "" && onesText != "") {
            groupWords += " ";
        }

        if (onesText != "") {
            if (tensText == "" && group > 99) {
                groupWords += "linh ";
            }
            groupWords += onesText;
        }

        if (group != 0) {
            groupWords += " " + scales[numGroups];
        }

        words = groupWords + " " + words;
        numGroups++;
    }

    words = words.trim();
    words = words.charAt(0).toUpperCase() + words.slice(1);
    words += " đồng";

    return words;
}