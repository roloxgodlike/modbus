/*
 * Copyright 2016 Kevin Herron
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.digitalpetri.modbus.requests;

import com.digitalpetri.modbus.FunctionCode;

/**
 * This function is used to read from 1 to 2000 contiguous status of coils in a remote device. The Request PDU
 * specifies the starting address, i.e. the address of the first coil specified, and the number of coils. In the PDU
 * Coils are addressed starting at zero. Therefore coils numbered 1-16 are addressed as 0-15.
 */
public class ReadCoilsRequest extends SimpleModbusRequest {

    private int address;
    private int quantity;

    /**
     * 无参构造, 需要手动set address/quantity
     */
    public ReadCoilsRequest() {
        super(FunctionCode.ReadCoils);
    }

    /**
     * @param address  0x0000 to 0xFFFF (0 to 65535)
     * @param quantity 0x0001 to 0x07D0 (1 to 2000)
     */
    public ReadCoilsRequest(final int address, final int quantity) {
        super(FunctionCode.ReadCoils);
        this.address = address;
        this.quantity = quantity;
    }

    /**
     * 设置地址值
     * @param address 地址值
     */
    public void setAddress(final int address) {
        this.address = address;
    }

    /**
     * 获取地址值
     * @return address 地址值
     */
    public int getAddress() {
        return this.address;
    }

    /**
     * 设置quantity
     * @param quantity 个数
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取quantity
     * @return quantity 个数
     */
    public int getQuantity() {
        return this.quantity;
    }

}
