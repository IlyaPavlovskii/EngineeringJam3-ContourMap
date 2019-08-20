package by.bulba.contour.map.common.provider

import by.bulba.contour.map.data.TaskDescription

interface TaskDescriptionProvider<out T:TaskDescription> {

    val taskDescriptions: List<T>
}