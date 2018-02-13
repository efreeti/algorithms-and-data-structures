package info.twobteam.structures.hashtables;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class HashTable<Key, Value> {
	public class Entry<Key, Value> {
		public final Key key;
		public final Value value;

		public Entry(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	private List<Entry<Key, Value>>[] entries = new List[] {new LinkedList<>()};
	private int size = 1;

	private List<Entry<Key, Value>> getEntriesList(Key key, boolean createIfMissing) {
		int hash = (int) (((long) (key.hashCode() & 0xFFFFFFFFL)) % entries.length);

		if (entries[hash] == null) {
			if (createIfMissing) {
				entries[hash] = new LinkedList<>();
			} else {
				return Collections.emptyList();
			}
		}

		return entries[hash];
	}

	private void changeCapacity(int newCapacity) {
		List<Entry<Key, Value>>[] currentEntries = entries;
		entries = new List[newCapacity];

		for (List<Entry<Key, Value>> entries : currentEntries) {
			if (entries != null) {
				entries.forEach(entry -> put(entry.key, entry.value));
			}
		}
	}

	public Optional<Value> get(Key key) {
		return getEntriesList(key, false).stream()
			.filter(entry -> entry.key.equals(key))
			.map(entry -> entry.value)
			.findFirst();
	}

	public void put(Key key, Value value) {
		List<Entry<Key, Value>> items = getEntriesList(key, true);

		for (int i = 0; i < items.size(); ++i) {
			if (items.get(i).key.equals(key)) {
				items.set(i, new Entry<>(key, value));

				return;
			}
		}

		items.add(new Entry<>(key, value));

		++size;

		if (size >= entries.length) {
			changeCapacity(entries.length * 2);
		}
	}

	public void remove(Key key) {
		List<Entry<Key, Value>> items = getEntriesList(key, false);

		for (int i = 0; i < items.size(); ++i) {
			if (items.get(i).key.equals(key)) {
				items.remove(i);
			}
		}

		--size;

		if (size < entries.length / 4) {
			changeCapacity(entries.length / 2);
		}
	}
}
