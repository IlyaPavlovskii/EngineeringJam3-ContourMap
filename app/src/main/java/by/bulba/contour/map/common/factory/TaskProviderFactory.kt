package by.bulba.contour.map.common.factory

import by.bulba.contour.map.common.provider.TaskDescriptionProvider
import by.bulba.contour.map.common.provider.TaskProvider
import by.bulba.contour.map.data.Task
import by.bulba.contour.map.data.TaskDescription

class TaskProviderFactory<out TD : TaskDescription, out TS : Task>(
    val taskDescriptionProvider: TaskDescriptionProvider<TD>
) {

    fun create(index: Int): TaskProvider<TS> {
        return object : TaskProvider<TS> {
            override val task: TS
                get() = taskDescriptionProvider.taskDescriptions[index].task as TS
        }
    }
}