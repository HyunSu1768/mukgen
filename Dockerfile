FROM openjdk:17

ENV PROFILE=$PROFILE
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
ENV REDIS_PORT=$REDIS_PORT
ENV REDIS_HOST=$REDIS_HOST
ENV MAIL_USERNAME=$MAIL_USERNAME
ENV MAIL_PASSWORD=$MAIL_PASSWORD
ENV JWT_SECRET_KEY=$JWT_SECRET_KEY
ENV JWT_ACCESS_EXP=$JWT_ACCESS_EXP
ENV JWT_REFRESH_EXP=$JWT_REFRESH_EXP
ENV JWT_HEADER=$JWT_HEADER
ENV JWT_PREFIX=$JWT_PREFIX
ENV GPT_SECRET=$GPT_SECRET
ENV AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID
ENV AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY
ENV SEGMENTS_ID=$SEGMENTS_ID
ENV FLARELANE_API_KEY=$FLARELANE_API_KEY

COPY build/libs/mukgen-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]