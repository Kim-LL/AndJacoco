package org.jacoco.agent.rt.internal;

/**
 * At several places exception might occur that should be reported. For
 * testability these exceptions are emitted against this interface.
 */
public interface IExceptionLogger {

	/**
	 * Default implementation which dumps the stack trace to System.err.
	 */
	IExceptionLogger SYSTEM_ERR = new IExceptionLogger() {
		public void logExeption(final Exception ex) {
			ex.printStackTrace();
		}
	};

	/**
	 * Logs the given exception.
	 *
	 * @param ex
	 *            exception to log
	 */
	void logExeption(Exception ex);

}
