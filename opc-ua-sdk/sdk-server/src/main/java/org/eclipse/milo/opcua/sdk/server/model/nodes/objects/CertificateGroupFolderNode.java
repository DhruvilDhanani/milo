/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server.model.nodes.objects;

import java.util.Optional;

import org.eclipse.milo.opcua.sdk.server.api.nodes.ObjectNode;
import org.eclipse.milo.opcua.sdk.server.model.types.objects.CertificateGroupFolderType;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNodeContext;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;

public class CertificateGroupFolderNode extends FolderNode implements CertificateGroupFolderType {
    public CertificateGroupFolderNode(UaNodeContext context, NodeId nodeId, QualifiedName browseName,
                                      LocalizedText displayName, LocalizedText description, UInteger writeMask,
                                      UInteger userWriteMask) {
        super(context, nodeId, browseName, displayName, description, writeMask, userWriteMask);
    }

    public CertificateGroupFolderNode(UaNodeContext context, NodeId nodeId, QualifiedName browseName,
                                      LocalizedText displayName, LocalizedText description, UInteger writeMask,
                                      UInteger userWriteMask, UByte eventNotifier) {
        super(context, nodeId, browseName, displayName, description, writeMask, userWriteMask, eventNotifier);
    }

    @Override
    public CertificateGroupNode getDefaultUserTokenGroupNode() {
        Optional<ObjectNode> component = getObjectComponent("http://opcfoundation.org/UA/", "DefaultUserTokenGroup");
        return (CertificateGroupNode) component.orElse(null);
    }

    @Override
    public CertificateGroupNode getDefaultHttpsGroupNode() {
        Optional<ObjectNode> component = getObjectComponent("http://opcfoundation.org/UA/", "DefaultHttpsGroup");
        return (CertificateGroupNode) component.orElse(null);
    }

    @Override
    public CertificateGroupNode getDefaultApplicationGroupNode() {
        Optional<ObjectNode> component = getObjectComponent("http://opcfoundation.org/UA/", "DefaultApplicationGroup");
        return (CertificateGroupNode) component.orElse(null);
    }
}
