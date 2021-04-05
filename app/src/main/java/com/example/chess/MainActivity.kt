package com.example.chess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ChessBoard.ChessBoardAdapter.CallBack, ChessBoard.ChesboardCallBack {

    val chessBoard = ChessBoard(this)
    val adapter = ChessBoard.ChessBoardAdapter(chessBoard.arrayCell, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myRecyclerView = findViewById<RecyclerView>(R.id.desc)

        myRecyclerView.adapter = adapter
        myRecyclerView.layoutManager = GridLayoutManager(this, 8)
        myRecyclerView.hasFixedSize()

    }

    override fun onSelectionChange(deskStates: DeskStates) {
        chessBoard.stateUpdate(deskStates)
    }

    override fun onRemoveSelection() {
        adapter.deselectLastPosition()
    }


}