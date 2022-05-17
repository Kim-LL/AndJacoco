package org.jacoco.agent.rt.internal;

import org.jacoco.core.runtime.RuntimeData;

/**
 * The API for classes instrumented in "offline" mode. The agent configuration
 * is provided through system properties prefixed with <code>jacoco.</code>.
 */
public final class Offline {

	private Offline() {
		// no instances
	}

	private static RuntimeData data;

	private static synchronized RuntimeData getRuntimeData() {
		if (data == null) {
			try {
				data = Agent.getInstance().getData();
			} catch (final Exception e) {
				throw new RuntimeException("Failed to initialize JaCoCo.", e);
			}
		}
		return data;
	}

	/**
	 * API for offline instrumented classes.
	 *
	 * @param classid
	 *            class identifier
	 * @param classname
	 *            VM class name
	 * @param probecount
	 *            probe count for this class
	 * @return probe array instance for this class
	 */
	public static boolean[] getProbes(final long classid,
			final String classname, final int probecount) {
		return getRuntimeData()
				.getExecutionData(Long.valueOf(classid), classname, probecount)
				.getProbes();
	}

}
