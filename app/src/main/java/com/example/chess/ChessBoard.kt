package com.example.chess

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

    fun stateUpdate(deskStates: DeskStates){

        if (this.deskStates == DeskStates.SELECTED){
            chesboardCallBack.onRemoveSelection()
        }
        this.deskStates = deskStates
    }
    interface ChesboardCallBack{
        fun onRemoveSelection()
    }
}