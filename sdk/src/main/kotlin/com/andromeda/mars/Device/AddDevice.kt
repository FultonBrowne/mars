package com.andromeda.mars.Device

interface AddDevice {
    fun DeviceInit()
    fun onDeviceInstall()
    fun onDeviceDeactivate()
}