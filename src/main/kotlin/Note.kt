import java.util.Scanner

class Note
    (
    private var commandNote: Int,
    private val noteListNew: MutableList<MutableList<String>>,
    ) : Menu {

    private val scan = Scanner(System.`in`)

        fun startNote() {

            titlePrintMenu()

            while (true) {

                if (scan.hasNextInt()) {

                    when (val commandMenuNote = scan.nextInt()) {

                        0 -> {
                            println("Введите имя заметки")
                            scan.nextLine()

                            var scanNameNote = scan.nextLine()
                            while (scanNameNote.isEmpty()) {
                                println("Имя не пожет быть пустым. Повторите ввод:")
                                scanNameNote = scan.nextLine()
                            }

                            val noteCreate = NoteCreate(scanNameNote)

                            noteListNew[commandNote-1].add(noteCreate.titleNote)

                            titlePrintMenu()

                        }


                        in (noteListNew[commandNote-1].indices + noteListNew[commandNote-1].size) -> {
                            println("Заметка $commandMenuNote")
                            println("Я тут")
                            println("${noteListNew[commandNote-1].size+1}. Выход")
                        }


                        noteListNew[commandNote-1].size+1 -> {
                            println("Выход...")
                            println(" ")
                            break
                        }


                        else -> println("Такой цифры нет, повторите ввод")

                    }
                } else {
                    println(" ")
                    println("Вы ввели не число, попробуйте снова!")
                    scan.next()
                }
            }

        }


        override fun titlePrintMenu() {
            println(
                """                         
                            Архив № $commandNote
                            Список заметок:
                            0. Создать заметку
                        """.trimIndent()
            )
            noteListNew[commandNote-1].forEachIndexed{ index, element -> println("${index + 1}. $element")}
            println("${noteListNew[commandNote-1].size+1}. Выход")
        }

}
