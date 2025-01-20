import java.util.Scanner

class Archive : Menu {

    private val scan = Scanner(System.`in`)
    private val archiveList: MutableList<String> = mutableListOf()
    private val noteList: MutableList<MutableList<String>> = mutableListOf()

    fun startArchive() {

        titlePrintMenu()

        while (true) {

            if (scan.hasNextInt()) {

                when (val commandMenuArchive = scan.nextInt()) {
                    0 -> {
                        println("Введите имя архива:")
                        scan.nextLine()

                        var scanNameArchives = scan.nextLine()

                            while (scanNameArchives.isEmpty()) {
                                println("Имя не пожет быть пустым. Повторите ввод:")
                                scanNameArchives = scan.nextLine()
                            }

                        val archiveCreate = ArchiveCreate(scanNameArchives)

                        archiveList.add(archiveCreate.titleArchive)     //записываю имена архивов в archiveList
                        noteList.add(archiveCreate.numberNoteList)  //записываю листы заметок в лист noteList

                        titlePrintMenu()
                    }


                    archiveList.size + 1 -> {
                        println("Выход из приложения...")
                        return
                    }


                    in (archiveList.indices + archiveList.size) -> {    //проблема, что начинается с 0 индексы, поэтому добавил archiveList.size

                        val note = Note (commandMenuArchive, noteList)

                        note.startNote()
                        titlePrintMenu()
                    }


                    else -> println("Такой цифры нет, повторите ввод")
                }

            }
            else {
                println(" ")
                println("Вы ввели не число, попробуйте снова!")
                scan.next()
            }
        }
    }



    override fun titlePrintMenu() {
        println("""
            Список архивов:
            0. Создать архив                      
        """.trimIndent())

        archiveList.forEachIndexed{ index, element -> println("${index + 1}. $element")}
        println("${archiveList.size+1}. Выход")
    }

}
