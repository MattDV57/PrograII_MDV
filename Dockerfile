FROM maven:3.9.5-eclipse-temurin-17

ENV NVM_VERSION v0.39.7
ENV NODE_VERSION v2.11.1
ENV NVM_DIR "/roo/.nvm"

RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/${NVM_VERSION}/install.sh | bash
RUN echo "source ${NVM_DIR}/nvm.sh && nvm install ${NODE_VERSION} && nvm use ${NODE_VERSION}" | bash

ENV NODE_PATH $NVM_DIR/$NODE_VERSION/lib/node_modules
ENV PATH $NVM_DIR/versions/node/$NODE_VERSION/bin:$PATH
