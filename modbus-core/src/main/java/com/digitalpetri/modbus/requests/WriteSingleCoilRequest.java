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
 * This function is used to write a single output to either ON or OFF in a remote device.
 * <p>
 * The requested ON/OFF state is specified by a constant in the request data field. A value of 0xFF00 requests the
 * output to be ON. A value of 0x0000 requests it to be OFF. All other values are illegal and will not affect the output.
 * <p>
 * The Request PDU specifies the address of the coil to be forced. Coils are addressed starting at zero. Therefore coil
 * numbered 1 is addressed as 0. The requested ON/OFF state is specified by a constant in the Coil Value field. A value
 * of 0XFF00 requests the coil to be ON. A value of 0X0000 requests the coil to be off. All other values are illegal and
 * will not affect the coil.
 */
public class WriteSingleCoilRequest extends SimpleModbusRequest {

    private int address;
    private int value;

    /**
     * 无参构造, 需要手动set address/value
     */
    public WriteSingleCoilRequest() {
        super(FunctionCode.WriteSingleCoil);
    }

    /**
     * @param address 0x0000 to 0xFFFF (0 to 65535)
     * @param value   true or false (0xFF00 or 0x0000)
     */
    public WriteSingleCoilRequest(final int address, final boolean value) {
        super(FunctionCode.WriteSingleCoil);

        this.address = address;
        this.value = value ? 0xFF00 : 0x0000;
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
     * 获取value
     * @return value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * 设置value
     * @param value 值
     */
    public void setValue(final boolean value) {
        this.value = value ? 0xFF00 : 0x0000;
    }

}
