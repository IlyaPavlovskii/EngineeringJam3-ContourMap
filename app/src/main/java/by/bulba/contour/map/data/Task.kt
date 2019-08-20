package by.bulba.contour.map.data

enum class TaskType {
    GEO_SELECTOR_QUIZ,
    REG_GEO_SELECTOR_QUIZ
}

interface Task

interface TaskDescription {
    val task: Task
    val type: TaskType
}