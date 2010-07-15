/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.http;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.Map;

import org.junit.Test;
import org.springframework.integration.message.GenericMessage;

/**
 * @author Dave Syer
 * @since 2.0
 *
 */
public class DefaultParameterMapperTests {

	@Test
	public void testFromMessage() throws Exception {
		DefaultParameterMapper mapper = new DefaultParameterMapper();
		Map<String, ?> params = mapper.fromMessage(new GenericMessage<Object>(Collections.singletonMap("foo", "bar")));
		assertEquals(1, params.size());
		assertEquals("bar", params.get("foo"));
	}

	@Test
	public void testFromMessageWithExpressions() throws Exception {
		DefaultParameterMapper mapper = new DefaultParameterMapper();
		mapper.setDynamicParameterExpressions(Collections.singletonMap("foo", "payload"));
		Map<String, ?> params = mapper.fromMessage(new GenericMessage<Object>("bar"));
		assertEquals(1, params.size());
		assertEquals("bar", params.get("foo"));
	}

}
