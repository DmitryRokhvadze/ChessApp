package com.example.chess

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ChessBoard(val chesboardCallBack: ChesboardCallBack) {

    val letters = arrayOf("H", "G", "F", "E", "D", "C", "B", "A")

    var arrayCell: MutableList<Cell> = mutableListOf()

    init {
        arrayCell = initDesc()
    }

    fun initDesc(): MutableList<Cell> {

        arrayCell.add(Cell(R.color.cellWhite, 8, letters[7]))
        arrayCell.add(Cell(R.color.cellBlack, 8, letters[7]))
        arrayCell.add(Cell(R.color.cellWhite, 8, letters[7]))
        arrayCell.add(Cell(R.color.cellBlack, 8, letters[7]))
        arrayCell.add(Cell(R.color.cellWhite, 8, letters[7]))
        arrayCell.add(Cell(R.color.cellBlack, 8, letters[7]))
        arrayCell.add(Cell(R.color.cellWhite, 8, letters[7]))
        arrayCell.add(Cell(R.color.cellBlack, 8, letters[7]))

        arrayCell.add(Cell(R.color.cellBlack, 7, letters[6]))
        arrayCell.add(Cell(R.color.cellWhite, 7, letters[6]))
        arrayCell.add(Cell(R.color.cellBlack, 7, letters[6]))
        arrayCell.add(Cell(R.color.cellWhite, 7, letters[6]))
        arrayCell.add(Cell(R.color.cellBlack, 7, letters[6]))
        arrayCell.add(Cell(R.color.cellWhite, 7, letters[6]))
        arrayCell.add(Cell(R.color.cellBlack, 7, letters[6]))
        arrayCell.add(Cell(R.color.cellWhite, 7, letters[6]))

        arrayCell.add(Cell(R.color.cellWhite, 6, letters[5]))
        arrayCell.add(Cell(R.color.cellBlack, 6, letters[5]))
        arrayCell.add(Cell(R.color.cellWhite, 6, letters[5]))
        arrayCell.add(Cell(R.color.cellBlack, 6, letters[5]))
        arrayCell.add(Cell(R.color.cellWhite, 6, letters[5]))
        arrayCell.add(Cell(R.color.cellBlack, 6, letters[5]))
        arrayCell.add(Cell(R.color.cellWhite, 6, letters[5]))
        arrayCell.add(Cell(R.color.cellBlack, 6, letters[5]))

        arrayCell.add(Cell(R.color.cellBlack, 5, letters[4]))
        arrayCell.add(Cell(R.color.cellWhite, 5, letters[4]))
        arrayCell.add(Cell(R.color.cellBlack, 5, letters[4]))
        arrayCell.add(Cell(R.color.cellWhite, 5, letters[4]))
        arrayCell.add(Cell(R.color.cellBlack, 5, letters[4]))
        arrayCell.add(Cell(R.color.cellWhite, 5, letters[4]))
        arrayCell.add(Cell(R.color.cellBlack, 5, letters[4]))
        arrayCell.add(Cell(R.color.cellWhite, 5, letters[4]))

        arrayCell.add(Cell(R.color.cellWhite, 4, letters[3]))
        arrayCell.add(Cell(R.color.cellBlack, 4, letters[3]))
        arrayCell.add(Cell(R.color.cellWhite, 4, letters[3]))
        arrayCell.add(Cell(R.color.cellBlack, 4, letters[3]))
        arrayCell.add(Cell(R.color.cellWhite, 4, letters[3]))
        arrayCell.add(Cell(R.color.cellBlack, 4, letters[3]))
        arrayCell.add(Cell(R.color.cellWhite, 4, letters[3]))
        arrayCell.add(Cell(R.color.cellBlack, 4, letters[3]))

        arrayCell.add(Cell(R.color.cellBlack, 3, letters[2]))
        arrayCell.add(Cell(R.color.cellWhite, 3, letters[2]))
        arrayCell.add(Cell(R.color.cellBlack, 3, letters[2]))
        arrayCell.add(Cell(R.color.cellWhite, 3, letters[2]))
        arrayCell.add(Cell(R.color.cellBlack, 3, letters[2]))
        arrayCell.add(Cell(R.color.cellWhite, 3, letters[2]))
        arrayCell.add(Cell(R.color.cellBlack, 3, letters[2]))
        arrayCell.add(Cell(R.color.cellWhite, 3, letters[2]))

        arrayCell.add(Cell(R.color.cellWhite, 2, letters[1]))
        arrayCell.add(Cell(R.color.cellBlack, 2, letters[1]))
        arrayCell.add(Cell(R.color.cellWhite, 2, letters[1]))
        arrayCell.add(Cell(R.color.cellBlack, 2, letters[1]))
        arrayCell.add(Cell(R.color.cellWhite, 2, letters[1]))
        arrayCell.add(Cell(R.color.cellBlack, 2, letters[1]))
        arrayCell.add(Cell(R.color.cellWhite, 2, letters[1]))
        arrayCell.add(Cell(R.color.cellBlack, 2, letters[1]))

        arrayCell.add(Cell(R.color.cellBlack, 1, letters[0]))
        arrayCell.add(Cell(R.color.cellWhite, 1, letters[0]))
        arrayCell.add(Cell(R.color.cellBlack, 1, letters[0]))
        arrayCell.add(Cell(R.color.cellWhite, 1, letters[0]))
        arrayCell.add(Cell(R.color.cellBlack, 1, letters[0]))
        arrayCell.add(Cell(R.color.cellWhite, 1, letters[0]))
        arrayCell.add(Cell(R.color.cellBlack, 1, letters[0]))
        arrayCell.add(Cell(R.color.cellWhite, 1, letters[0]))

        return arrayCell
    }

    var deskStates = DeskStates.NOT_SELECTED

    fun stateUpdate(deskStates: DeskStates) {

        if (this.deskStates == DeskStates.SELECTED) {
            chesboardCallBack.onRemoveSelection()
        }
        this.deskStates = deskStates
    }

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
            if (cell.position == 2 || cell.position == 7) {
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
                    if (deselectCall) {
                        viewHolder.selectItem.visibility = View.GONE
                    }
                }
            }
            if (deselectCall) {
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
    interface ChesboardCallBack {
        fun onRemoveSelection()
    }
}