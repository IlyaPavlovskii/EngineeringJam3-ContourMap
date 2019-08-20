package by.bulba.contour.map.common.provider

import by.bulba.contour.map.data.Task

interface TaskProvider<out T : Task> {
    val task: T
}