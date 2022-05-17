package org.jacoco.agent.rt;

import org.jacoco.agent.rt.internal.Agent;

/**
 * Entry point to access the JaCoCo agent runtime.
 */
public final class RT {

	private RT() {
	}

	/**
	 * Returns the agent instance of the JaCoCo runtime in this JVM.
	 *
	 * @return agent instance
	 * @throws IllegalStateException
	 *             if no Agent has been started yet
	 */
	public static IAgent getAgent() throws Exception {
		return Agent.getInstance();
	}

}
