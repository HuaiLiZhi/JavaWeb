import {printLog} from "./utils.js"

document.querySelector('#b2').addEventListener('click', () => {
    printLog("我被点击了")
})

document.querySelector('#last').addEventListener('mouseenter', () => {
    console.log("鼠标移入了")
})

document.querySelector('#last').addEventListener('mouseleave', () => {
    console.log("鼠标移出了")
})

document.querySelector('#username').addEventListener('keyup', () => {
    console.log("键盘被抬起了")
})

document.querySelector('#username').addEventListener('keydown', () => {
    console.log("键盘被按下了")
})

document.querySelector('#age').addEventListener('blur', () => {
    console.log("失去焦点")
})

document.querySelector('#age').addEventListener('focus', () => {
    console.log("获得焦点")
})

document.querySelector('#age').addEventListener('input', () => {
    console.log("用户输入时触发")
})

document.querySelector('form').addEventListener('submit', () => {
    console.log("表单被提交了")
})