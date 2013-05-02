package factory;
public interface ISubject {

	public void registerObserver(IObserver observer);

	public void unregisterObserver(IObserver observer);

	public void notifyObservers();
}