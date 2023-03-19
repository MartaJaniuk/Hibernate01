package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDao publisherDao;

    public PublisherServiceImpl(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @Override
    public void save(Publisher publisher) {
        publisherDao.save(publisher);
    }

    @Override
    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherDao.findById(id);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }
    @Override
    public void deleteById(Long id) {
        publisherDao.deleteById(id);
    }

}
