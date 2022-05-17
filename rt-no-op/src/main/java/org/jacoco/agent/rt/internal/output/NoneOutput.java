package org.jacoco.agent.rt.internal.output;

import org.jacoco.core.runtime.RuntimeData;

/**
 * Output that does nothing.
 */
public class NoneOutput implements IAgentOutput {

	public final void startup(
			final RuntimeData data) {
		// Nothing to do
	}

	public void writeExecutionData(final boolean reset) {
		// Nothing to do
	}

	public void shutdown() {
		// Nothing to do
	}

}
