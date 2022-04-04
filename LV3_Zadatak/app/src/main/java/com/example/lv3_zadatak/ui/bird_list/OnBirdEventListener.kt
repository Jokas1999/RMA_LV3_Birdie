package com.example.lv3_zadatak.ui.bird_list

import com.example.lv3_zadatak.model.Bird

interface OnBirdEventListener {
    fun onBirdSelected(id: Long?)
    fun onBirdLongPress(task: Bird?): Boolean
}