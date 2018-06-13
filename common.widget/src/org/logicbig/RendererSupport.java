package org.logicbig;

import org.widgets.SimpleRenderer;

public class RendererSupport {
	public void render(Object object) {
		new SimpleRenderer().renderAsString(object);
	}
}
