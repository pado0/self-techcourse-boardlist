package example.techcourse0613.service;

import example.techcourse0613.entity.FileInfo;
import example.techcourse0613.repository.FileInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FileInfoService {

    private final FileInfoRepository fileInfoRepository;

    @Transactional
    public void saveFileInfo(FileInfo fileInfo) {
        fileInfoRepository.save(fileInfo);
    }

    public FileInfo findOneFileInfoById(Long id) {
        return fileInfoRepository.findFileInfoById(id);
    }
}
