package com.ssafy.project.db.repository;

import com.ssafy.project.db.entity.MemberConference;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

public interface MemberConferenceRepository extends JpaAttributeConverter<MemberConference, Long> {
}
