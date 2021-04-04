package com.example.chess

import android.view.View

open class ChessPiece(posNumber: Int, posletter: String, piecePic: View){
    var number = posNumber
    var letter = posletter

    open fun move(moveToNum: Int, moveToLetter: String){
        this.number = moveToNum
        this.letter = moveToLetter
    }
}