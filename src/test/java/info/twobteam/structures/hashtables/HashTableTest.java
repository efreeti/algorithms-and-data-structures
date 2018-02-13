package info.twobteam.structures.hashtables;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HashTableTest {
	@Test
	public void shouldAccessKey() {
		HashTable<String, String> hashTable = new HashTable<>();

		hashTable.put("key1", "value1");
		hashTable.put("key2", "value2");
		hashTable.put("key3", "value3");
		hashTable.put("key4", "value4");
		hashTable.put("key5", "value5");

		assertThat(hashTable.get("key1").get(), is("value1"));
		assertThat(hashTable.get("key2").get(), is("value2"));
		assertThat(hashTable.get("key3").get(), is("value3"));
		assertThat(hashTable.get("key4").get(), is("value4"));
		assertThat(hashTable.get("key5").get(), is("value5"));
		assertThat(hashTable.get("non existing").isPresent(), is(false));
	}

	@Test
	public void shouldRemoveKey() {
		HashTable<String, String> hashTable = new HashTable<>();

		hashTable.put("key1", "value1");
		hashTable.put("key2", "value2");
		hashTable.put("key3", "value3");
		hashTable.put("key4", "value4");
		hashTable.put("key5", "value5");
		hashTable.remove("key1");
		hashTable.remove("key3");
		hashTable.remove("key5");

		assertThat(hashTable.get("key1").isPresent(), is(false));
		assertThat(hashTable.get("key2").get(), is("value2"));
		assertThat(hashTable.get("key3").isPresent(), is(false));
		assertThat(hashTable.get("key4").get(), is("value4"));
		assertThat(hashTable.get("key5").isPresent(), is(false));
		assertThat(hashTable.get("non existing").isPresent(), is(false));
	}
}
