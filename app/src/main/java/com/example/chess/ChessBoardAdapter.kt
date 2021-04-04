package com.example.chess

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView

class ChessBoardAdapter(private val dataSet: MutableList<Cell>, val callBack: CallBack) :
        RecyclerView.Adapter<ChessBoardAdapter.ViewHolder>() {

    var lastSelectedPosition = 0
    var deselectCall = false
    var lastPickAreChess = false

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellFrameLayout: FrameLayout
        val selectItem: View
        val pawn: View

        init {
            cellFrameLayout = view.findViewById(R.id.cell)
            selectItem = view.findViewById(R.id.selectionView)
            pawn = view.findViewById(R.id.pawn)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.cell, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val cell = dataSet.get(position)

        val pawn = ChessPiece(cell.position, cell.fieldPosition, viewHolder.pawn)

        val context = viewHolder.cellFrameLayout.context

        viewHolder.cellFrameLayout.setBackgroundColor(ContextCompat.getColor(context, cell.cellColor))
        if (cell.position == 2 || cell.position == 7){
            viewHolder.pawn.visibility = View.VISIBLE
        }
        viewHolder.cellFrameLayout.setOnClickListener {

            if (viewHolder.selectItem.visibility == View.VISIBLE) {
                viewHolder.selectItem.visibility = View.GONE
                //hasSelection = false
                Log.e("TAG", "рамка пропала, $position")
                callBack.onSelectionChange(DeskStates.NOT_SELECTED)
            } else {
                viewHolder.selectItem.visibility = View.VISIBLE
                viewHolder.pawn.visibility = View.VISIBLE
                Log.e("TAG", "рамка появилась, $position")
                callBack.onSelectionChange(DeskStates.SELECTED)
                lastSelectedPosition = position
                if (deselectCall){
                    viewHolder.selectItem.visibility = View.GONE
                }
            }
        }
        if (deselectCall){
            viewHolder.selectItem.visibility = View.GONE
            viewHolder.pawn.visibility = View.GONE
            deselectCall = false
            lastSelectedPosition = -1
        }
    }


    override fun getItemCount() = dataSet.size

    fun deselectLastPosition() {
        deselectCall = true
        notifyItemChanged(lastSelectedPosition)
        Log.e("TAG", "отработала очистка, $lastSelectedPosition")
    }

    interface CallBack {
        fun onSelectionChange(deskStates: DeskStates)

    }

}