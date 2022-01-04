/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
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

package com.wrh.sublet.common.log.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 日志类型
 *
 * @author wrh
 * @date 2021/10/13
 */
@Getter
@RequiredArgsConstructor
public enum LogTypeEnum {

	/**
	 * 正常日志类型
	 */
	NORMAL(0, "正常日志"),

	/**
	 * 错误日志类型
	 */
	ERROR(1, "错误日志");

	/**
	 * 类型
	 */
	private final int type;

	/**
	 * 描述
	 */
	private final String description;

}
