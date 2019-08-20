package by.bulba.contour.map.data

class GeoSelectorTaskDescription(private val _task: Task, private val _type: TaskType) : TaskDescription {
    override val task: Task
        get() = _task
    override val type: TaskType
        get() = _type
}