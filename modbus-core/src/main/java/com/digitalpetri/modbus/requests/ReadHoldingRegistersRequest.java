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
 * This function is used to read the contents of a contiguous block of holding registers in a remote device. The
 * Request PDU specifies the starting register address and the number of registers. In the PDU Registers are addressed
 * starting at zero. Therefore registers numbered 1-16 are addressed as 0-15.
 */
public class ReadHoldingRegistersRequest extends SimpleModbusRequest {

    private int address;
    private int quantity;

    /**
     * 无参构造, 需要手动set address/quantity
     */
    public ReadHoldingRegistersRequest() {
        super(FunctionCode.ReadHoldingRegisters);
    }

    /**
     * @param address  0x0000 to 0xFFFF (0 to 65535)
     * @param quantity 0x0001 to 0x007D (1 to 125)
     */
    public ReadHoldingRegistersRequest(final int address, final int quantity) {
        super(FunctionCode.ReadHoldingRegisters);

        this.address = address;
        this.quantity = quantity;
    }

    /**
     * 获取address
     * @return address
     */
    public int getAddress() {
        return this.address;
    }

    /**
     * 设置address
     * @param address 地址值
     */
    public void setAddress(final int address) {
        this.address = address;
    }

    /**
     * 获取quantity
     * @return quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * 设置quantity
     * @param quantity 个数
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
