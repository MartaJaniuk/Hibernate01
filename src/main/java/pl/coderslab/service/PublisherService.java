package pl.coderslab.service;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

public interface PublisherService {

    public void save(Publisher publisher);

    public void update(Publisher publisher);

    public Publisher findById(Long id);

    public void deleteById(Long id);
}
